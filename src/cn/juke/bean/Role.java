package cn.juke.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role",catalog="juker")
public class Role {
    @Id
    @GeneratedValue
	private Long id;
	
    private String name;
    
    private Long comid;
    
    private String create_time;
    
    private String descr;

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public Role(Long id, String name, Long comid, String descr) {
		super();
		this.id = id;
		this.name = name;
		this.comid = comid;
		this.descr = descr;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "m_t", 
         joinColumns = { @JoinColumn(name = "role_id") }, 
         inverseJoinColumns = { @JoinColumn(name = "node_id") })
    private Set<TreeNode> nodes=new HashSet<TreeNode>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<TreeNode> getNodes() {
		return nodes;
	}

	public void setNodes(Set<TreeNode> nodes) {
		this.nodes = nodes;
	}
	
	public Role(){}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", create_time="
				+ create_time + "]";
	}
}




